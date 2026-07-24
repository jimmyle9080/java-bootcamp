1. Advantages of Streams over loops
   Streams let me describe what I want done instead of writing out the iteration by hand. There's no index or counter to manage, which removes a common source of bugs. The filter/map/collect chain also reads clearly from top to bottom, and it can run in parallel with parallelStream() when the dataset is large.

2. When should Streams be preferred
   When I'm filtering, transforming, or aggregating a collection, the "give me X where Y" type of query. For complex control flow or heavy side effects in the middle of a loop, a traditional for loop is the clearer choice.

3. Difference between filter() and map()
   filter keeps the same type and reduces how many elements pass through, dropping the ones that don't match. map keeps the same count but transforms each element into a new form. In short: filter keeps or drops, map transforms.

4. Why is reduce() useful
   reduce combines an entire stream into a single value using an identity and an accumulator. It handles rollups that don't have a built-in method, like a product or a joined string. I used it for highest and lowest salary with reduce(Double::max) and reduce(Double::min).

5. What does Collectors.groupingBy() do
   It groups elements by a key and returns a Map. Each bucket defaults to a List, but a downstream collector like counting() or summarizingDouble() changes what each bucket stores. I used it for the department map and the per-department salary statistics.

6. Benefit of Optional
   Optional makes the "no value" case explicit, so an empty result can't turn into a null and cause an NPE later. It requires the caller to handle the empty case with ifPresent or orElse. I used it for the highest-paid and top-performer lookups, since an empty list has no answer.

7. Why are lambdas more readable
   The behavior sits inline where it's used instead of inside a multi-line anonymous class. e -> e.getSalary() > 100000 is a single line compared to a full Predicate block, so the intent is easy to see.

8. When should method references be used
   When the lambda only forwards its argument to one existing method, such as Employee::getName instead of e -> e.getName(). If the lambda adds any logic, I keep it as a lambda.

9. Which stream operation is terminal (three examples)
   Terminal operations trigger the pipeline and end it. From my lab: collect, count, and forEach (max is another).

10. How do Streams improve enterprise Java applications
    They replace nested loops with readable filter/map/group/collect pipelines. Reducing mutable state leads to fewer bugs and easier testing, and the same approach carries over when data comes from a database rather than an in-memory list.

11. Forward look: CRM reuse
    The same operations apply, with customers in place of employees. I would filter active customers in a region, map them to summary views, and use groupingBy on segment or agent for reports such as lifetime value per region. The CRM isn't built yet, but the filter/map/group approach transfers directly to Lab 8 and beyond.

1. Why do stream pipelines postpone work until a terminal operation runs?
   Intermediate operations are lazy, so they only record what should happen and build the pipeline. The work runs only when a terminal operation is called, and data then flows through one element at a time. This avoids unnecessary computation and allows short-circuiting operations like findFirst to stop early.

2. When is a lambda clearer than a named method, and when should you extract a method?
   A lambda is clearer for short, one-off behavior used in a single place, like a filter predicate. If the logic gets long, is reused in several pipelines, or needs a descriptive name to explain intent, I extract it into a named method or a method reference instead.

3. Difference between filter() and map()
   filter keeps the same element type and reduces the count by dropping elements that fail the predicate. map keeps the same count but transforms each element into a new form, which may be a different type. filter changes how many, map changes what.

4. Why prefer Comparator.comparingDouble(Employee::getSalary).reversed() over a hand-written compare?
   It states the intent directly as "by salary, descending," so it is easy to read and hard to get backwards. A hand-written compare is easy to invert by mistake or to break on ties. Building from comparingDouble also chains cleanly with thenComparing for tie-breaks.

5. What does Collectors.groupingBy(Employee::getDepartment) give you that a single List does not?
   It returns a Map keyed by department, with each value being the employees in that department. A single List would still require manual iteration to separate the groups. The grouped Map lets me report per department directly, and a downstream collector can summarize each group in the same pass.

6. Why return Optional<Employee> from "highest paid" instead of a nullable Employee?
   An empty roster has no highest-paid employee, so there may genuinely be no value. Optional makes that case explicit and forces the caller to handle it with ifPresent or orElse, rather than returning null and risking a NullPointerException later.

7. When should you use a method reference vs a lambda?
   Use a method reference when the lambda only forwards its argument to one existing method, such as Employee::getName in place of e -> e.getName(). Use a lambda when the body does something more, like a comparison or a calculation, that a method reference cannot express.

8. How will CRM later reuse filter/map/group thinking for customers?
   The same operations apply with customers in place of employees. A CRM would filter active customers in a region, map them to summary views, and use groupingBy on segment or agent for reports such as lifetime value per region. The CRM is not built here, but the filter, map, and group approach transfers directly to Lab 8 and later.