class Client
{
    String name 
}

Client client = new Client(name: 'Infosys Technologies')

def name = client.getName() ?: ""
println name 

Client client2 = new Client()
def name2 = client2.getName()?: "Default Name"
println name2

Client client3 = null
def name3 = client3?.getName()?: "Not Null Name"
println name3

/* 
    Output
    ------

    C:\raghs\prfsnl\GitHubRepos\TechNotes\groovyNotes\features\operators>groovy ElvisOperator.groovy
    Infosys Technologies
    Default Name
    Not Null Name

*/