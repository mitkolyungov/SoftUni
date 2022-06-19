function exam(input){

    let command = input.shift();
    let startMeters = 5364;
    let daysCount = 1;

    let totalMeters = startMeters+0;

    while(command!=="END" && totalMeters<8848 ){
        let meters = Number(input.shift());

        if(command=="Yes"){
            daysCount++;
            
            if(daysCount==6){
                break;
            }
        }

        totalMeters+=meters;

        command = input.shift();
    }

    if(totalMeters>=8848){
        console.log(`Goal reached for ${daysCount} days!`)
    }else{
        console.log(`Failed!\n${totalMeters}`)
    }
}