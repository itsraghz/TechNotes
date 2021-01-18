def xml1 = 'sample.xml'

def xml = """
<langs type="current">
  <language>Java</language>
  <language>Groovy</language>
  <language>JavaScript</language>
</langs>
"""

new XmlSlurper().parseText( xml )
                .langs
                .language
                .collectEntries { c->
                    [ c.@name, c.attributes() ]
                }
                
 def xml2 = """<?xml version="1.0" encoding="UTF-8"?>
<bla-module version="2.0" >
    <configurations>
            <conf name="one" visibility="public" description="Configuration one."/>
            <conf name="two" visibility="private" description="Configuration two."/>
    </configurations>
</bla-module>
 """
 
 new XmlSlurper().parseText( xml2 )
                .configurations
                .conf
                .collectEntries { c->
                    [ c.@name, c.attributes() ]
                }
                
                
def xml3="""<root>
<node1>
<value1>AA</value1>
<value2>123</value2>
</node1>
<node2>
<value1>AA</value1>
<value2>999</value2>
</node2>
<node3>
<value1>AB</value1>
<value2>456</value2>
</node3>
<node4>
<value1>AB</value1>
<value2>888</value2>
</node4>
</root>
"""
 new XmlSlurper().parseText( xml3 )
                .root
                .node1
                .value1
                .collectEntries { c->
                    //[ c.@name, c.attributes() ]
                    println c.@name
                }