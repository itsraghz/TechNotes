def xml = 'sports.xml'

def sports = new XmlSlurper().parse('sports.xml')
println sports.getClass().getName()
println sports.sport[2].name

mapOfXmlElements = sports.sport.collectEntries { c ->[c.@id, c.name]}
println mapOfXmlElements


def convertToMap(nodes) {
    nodes.children().collectEntries { 
        [ it.name, it.childNodes() ? convertToMap(it) : it.text() ] 
    }
}
sports = new XmlSlurper().parse('sports.xml')
println convertToMap(sports)