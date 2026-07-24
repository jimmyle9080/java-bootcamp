main frame created → holds count = 1 and person (a reference, not the object)

new Person("Aman") → object allocated on the heap; person now points to it

printPerson(person) → 2nd frame created → holds its own person param (copy of the reference, same object) + nameLength = 4

Both frames' references point to the same heap Person

printPerson returns → its frame popped (nameLength + param gone; heap object untouched)

main returns → its frame popped
