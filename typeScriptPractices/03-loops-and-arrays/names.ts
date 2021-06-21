let names : string[] = ['Raghavan', 'Kannan', 'Muthu', 'Balaji'];

for(let i = 0; i < names.length; i++) {
    console.log(names[i]);
}


console.log("------------------");
console.log("Simplified For Loop Output");
console.log("------------------");

// Simplified For Loop 

for(let name of names) {
    console.log(name);
}