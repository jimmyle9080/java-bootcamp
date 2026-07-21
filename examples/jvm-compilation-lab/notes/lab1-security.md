# Lab 1 — Security and Production Review
Jimmy Le-Nguyen

**1. Bytecode as artifact — why forbid copying raw .class between machines without a reproducible build?**
If you just copy a .class file around, nobody can actually prove where it came from. You don't know what source built it, which version it was, or whether someone changed it along the way. A real build pipeline like Maven or CI fixes that because it always rebuilds from versioned source, spits out artifacts you can trace, and can sign them. That way the team knows exactly what's running in production and can rebuild the same thing later if they need to.

**2. Heap dumps — privacy risk if customer PII sits in memory? Who should access dumps?**
A heap dump is basically a snapshot of everything the program had in memory at that moment, so if customer data was sitting there (names, account numbers, tokens) it all gets written to disk in plain text. You have to treat a dump like the sensitive data it contains: lock down who can see it to on-call and security folks, keep it encrypted, delete it once you're done, and never drop it in a Git repo or paste it into a chat.

**3. Logging secrets — why never print passwords or cloud keys, even in a tiny training main?**
Logs stick around. They get collected, stored, backed up, and a lot of people can read them. So if you print a password or an API key even once, it can end up sitting in log storage and dashboards basically forever. And the bigger reason is habit. If you get comfortable logging secrets in throwaway code, you'll eventually do it in code that matters, so it's better to just never do it.

**4. Classpath trust — risk if a malicious Employee.class appears earlier on the classpath than your build output?**
The JVM runs the first version of a class it finds on the classpath. So if an attacker sneaks their own Employee.class in ahead of yours, the JVM runs their code instead of yours, with all the same permissions your app has. That's basically arbitrary code execution. You avoid it by controlling what's on the classpath and only trusting artifacts that come from a verified, signed build.

**5. Flag/container limits — why is setting -Xmx without matching container memory limits dangerous?**
If you set -Xmx higher than what the container is actually allowed to use, the JVM thinks it has more room than it really does. It'll keep growing the heap, and once it blows past the container's memory limit the orchestrator (something like Kubernetes) just kills the process, usually with no warning. So -Xmx has to fit inside the container limit, with some room left over for the memory the JVM uses outside the heap. Using -XX:MaxRAMPercentage instead lets it scale to the container automatically.

**6. Three controls Northstar would add before real customer workloads:**
Run the app as a non-root user, set container memory and CPU limits that actually match the JVM flags, and only ship artifacts that came out of CI and are signed, with no secrets baked into the logs or the image.
EOF
