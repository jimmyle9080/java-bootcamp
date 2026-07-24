| Operation / API | Used? | Where (method / menu) | Notes |
| --------------- | :---: | --------------------- | ----- |
| Lambda `forEach` | Yes | `demonstrateLambdas` / menu 10 | `e -> System.out.println(e.getName())` |
| `Predicate` | Yes | `demonstrateFunctionalInterfaces` / menu 11 | `highEarner`: salary > 100k |
| `Function` | Yes | `demonstrateFunctionalInterfaces` / menu 11 | `employeeSummary`: Employee -> String |
| `Consumer` | Yes | `demonstrateFunctionalInterfaces` / menu 11 | `printRating` |
| `Supplier` | Yes | `demonstrateFunctionalInterfaces` / menu 11 | `topSample`: highest paid |
| `filter` | Yes | `displayItEmployees`, `displayFilteredItTopPerformers`, `displayActiveEmployees` / menu 7, 13, 14 | salary / dept / active / rating gates |
| `map` | Yes | `demonstrateMapping`, `displayDistinctDepartments` / menu 15, 2 | project to name / salary / dept |
| `sorted` | Yes | `demonstrateSorting`, `getTopSalaries` / menu 16, 8 | salary / name / experience order |
| `distinct` | Yes | `displayDistinctDepartments`, dashboard | unique departments |
| `limit` / `skip` | Yes | `displayTopAndNextSalaries` / menu 17 | top 5 / next 5 |
| `count` | Yes | `displayCounts`, dashboard / menu 18, 8 | headcount queries |
| `reduce` | Yes | `displayReductions` / menu 3 | `Double::max`, `Double::min` fold |
| `collect(toList/toSet)` | Yes | `demonstrateCollectors`, `getTopSalaries` | `toList()` / `toSet()` |
| `groupingBy` | Yes | `displayGroupedEmployees`, `getDepartmentStatistics`, `findDepartmentWithHighestAverageSalary` / menu 2, 6, 8 | department maps |
| `partitioningBy` | Yes | `displayPartitionedEmployees` / menu 3 | salary > 100k true/false |
| `summarizingDouble` | Yes | `displaySummaryStatistics`, dashboard / menu 3, 6, 8 | one-pass stats |
| `Optional` (`max` / `ifPresent`) | Yes | `findTopPerformer`, `displayHighestPaidEmployeeOptional` / menu 5, 8 | safe lookups, never `.get()` |
| Method references | Yes | throughout / menu many | `Employee::getName`, `System.out::println`, `Employee::isActive` |
| Dashboard composed report | Yes | `ReportService.displayDashboard` / menu 8 | composes service queries into one view |