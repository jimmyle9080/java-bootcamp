1. Why should Account be abstract rather than a concrete empty type?
   There is no such thing as a generic account. Every real account is a Savings or a Current with its own rules. Making Account abstract blocks new Account(...), so a meaningless, typeless account can never be created, while subclasses still share its deposit and withdraw logic.

2. Where does dynamic dispatch show up when you call displayAccount() on Account[]?
   In displayAccounts(). The array is typed Account, but when the loop calls displayAccount(), the JVM checks each object's real type and runs the SavingsAccount or CurrentAccount version. That runtime decision is dynamic dispatch.

3. How does Printable differ from extending a base class?
   Printable is a capability (can-do), so a class implements it, and a class can implement many interfaces. Extending Account is identity (is-a), and a class can only extend one parent. Customer implements Printable but is not an Account.

4. What would break if Main owned all the arrays instead of BankService?
   Main would handle menu input, data storage, and operations all at once, which breaks Single Responsibility. It would become large and hard to test, and changing how data is stored would force edits to the menu code. Keeping storage in BankService means one class owns the data and Main just routes choices.

5. How do today's Customer/Account patterns prepare you for later CRM entity design without building Spring here?
   The same habits scale up: model real business entities, keep their state encapsulated, and put operations in a service layer. Frameworks like Spring automate the wiring later, but the object-oriented design thinking is identical.