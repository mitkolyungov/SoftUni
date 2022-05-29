function greetingByNmae(input){
    let name = input[0];
    let numberOfProjects = (Number)(input[1]);
    let timeNeeded = numberOfProjects*3.0;
    console.log("The architect "+ name
     + " will need "+timeNeeded+" hours to complete "+numberOfProjects 
     +" project/s.");
}
