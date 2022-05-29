function greetingByNmae(input){
    let name = input[0];
    let familyName = input[1];
    let age = (Number)(input[2]);
    let city  = input[3];
    console.log("You are "+ name
     + " "+familyName+", a "+age+"-years old person from "+city+".");
}