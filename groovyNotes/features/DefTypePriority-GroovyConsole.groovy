def s = 'this is a string'
println s.class
assert s.class == java.lang.String
def gs = "this might be a GString"
println gs.class
assert gs.class == java.lang.String
assert !(gs instanceof GString)

gs = "If I put in a placeholder, this really is a GString: ${1+1}"
println gs.class
assert gs instanceof GString

def picard = '''
(to the tune of Let It Snow)
Oh the vacuum outside is endless
Unforgiving, cold, and friendless
But still we must boldly go
Make it so, make it so, make it so!
'''
println picard.class
def quote = """
There are ${Integer.toBinaryString(2)} kinds of people in the world:
Those who know binary, and those who don't
"""
println quote.class
assert quote == '''
There are 10 kinds of people in the world:
Those who know binary, and those who don't
'''
println quote.class