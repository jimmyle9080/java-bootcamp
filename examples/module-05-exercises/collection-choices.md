# Collection choices

| # | Scenario | Need | Interface | Implementation | Why |
| - | -------- | ---- | --------- | -------------- | --- |
| 1 | Ordered catalog; duplicate titles allowed | order | `List<Book>` | `ArrayList<>` | Indexed sequence; duplicates OK |
| 2 | Unique registered book IDs | unique | `Set<String>` | `HashSet<>` | No duplicates; fast membership |
| 3 | Book ID → current borrower ID | key→value | `Map<String, String>` | `HashMap<>` | Direct key → value lookup |
| 4 | Alphabetically sorted categories | unique + sorted | `Set<String>` | `TreeSet<>` | Unique values; natural sort order |
| 5 | Category → count, sorted by category | key→value + sorted | `Map<String, Integer>` | `TreeMap<>` | Key → value with sorted keys |
| 6 | Checkout history in event order | order | `List<BorrowRecord>` | `ArrayList<>` | Append + iterate in insertion order |