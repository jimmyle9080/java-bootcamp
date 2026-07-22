# Lab 3 Design Note

Encapsulation: Account's fields are private. Balance changes only through
deposit() and withdraw(), which validate first. setBalance is protected, so
subclasses can update it but outside code can't set an illegal value.

Inheritance: Account is the shared base. SavingsAccount and CurrentAccount
extend it and reuse deposit/withdraw, adding only what's unique (interest or fee).

Abstraction: Account is abstract, so new Account(...) won't compile. Its
abstract displayAccount() forces each subclass to define its own display.

Interface: Printable is a one-method contract. Customer and both account types
implement it, so any printable object displays the same way.

Polymorphism: BankService holds an Account[] of both types. displayAccounts()
calls displayAccount() and the JVM runs the right version at runtime, no casts.
The fee works the same way: withdraw() calls calculateCharges(), which
CurrentAccount overrides.

SOLID:
- SRP: Main = menu, BankService = operations, models = own state.
- OCP: new account type = new subclass, no edits to existing classes.
- LSP: Savings/Current work anywhere an Account is expected.
- ISP: Printable has one method, nothing unused.
- DIP: Main depends on the BankService API, not raw arrays.

Notes: double for teaching (BigDecimal in production); loops use a live count,
not .length; one shared Scanner injected into BankService.