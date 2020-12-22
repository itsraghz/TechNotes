/* Adding a new method to java.lang.String class at runtime */

String.metaClass.isPalindrome = {->
delegate == delegate.reverse()
}
word = 'tattarrattat'
println word.class
println "$word is a palindrome? ${word.isPalindrome()}"
word = 'Groovy'
println "$word is a palindrome? ${word.isPalindromeCheck()}"

