//Ranges are collections in Groovy consisting of two values separated by a pair of dots.
//Ranges are normally used as parts of other expressions, like loops, but they can be
//used by themselves.

Range bothEnds = 5..8
assert bothEnds.contains(5)
assert bothEnds.contains(8)
assert bothEnds.from == 5
assert bothEnds.to == 8
assert bothEnds == [5, 6, 7, 8]

// Using two dots includes the boundaries. To exclude the upper boundary, use a lessthan sign:

Range noUpper = 5..<8
assert noUpper.contains(5)
assert !noUpper.contains(8)
assert noUpper.from == 5
assert noUpper.to == 7
assert noUpper == [5, 6, 7]

//A range of numbers iterates over the contained integers. Other library classes can be
//used in ranges. Strings go letter by letter:

assert 1..5 == [1,2,3,4,5]
assert 'A'..'E' == ["A","B","C","D","E"]