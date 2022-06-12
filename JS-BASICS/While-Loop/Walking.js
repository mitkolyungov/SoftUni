function walking(input) {
    let targetSteps = 10000;

    let index = 0;

    let command =input[index++];
    let steps = 0;

    while (command !== "Going home") {
        steps += Number(command);
        if(steps>=targetSteps){
            console.log(`Goal reached! Good job!`);
            console.log(`${steps-targetSteps} steps over the goal!`);
            return;
        }
        command = input[index++];
        
    }

    steps+=Number(input[index]);

    if(steps>=targetSteps){
        console.log(`Goal reached! Good job!`);
        console.log(`${steps-targetSteps} steps over the goal!`);
    }else{
        console.log(`${targetSteps-steps} more steps to reach goal.`);
    }
}