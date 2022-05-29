function isExcelent(input){
    let recordInSeconds = Number(input[0]);
    let distance = Number(input[1]);
    let secondPerMeter = Number(input[2]);
    
    let resistanceSecondsLost = (Math.floor(distance/15))*12.5;
    
    let totalTime = distance*secondPerMeter+resistanceSecondsLost;
    
    if(totalTime<recordInSeconds){
        console.log(`Yes, he succeeded! The new world record is ${totalTime.toFixed(2)} seconds.`);
    }else{
        console.log(`No, he failed! He was ${((recordInSeconds-totalTime)*(-1)).toFixed(2)} seconds slower.`)
    }
    }