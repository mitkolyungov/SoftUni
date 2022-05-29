isOnTime(input){
    let examBeginHour = Number(input[0]);
    let examBeginMin = Number(input[1]);
    let arrivedHour = Number(input[2]);
    let arrivedMin = Number(input[3]);

    let difference = 0;

    if(examBeginHour==arrivedHour){
        difference = examBeginMin - arrivedMin;
    }else {
        difference = (examBeginHour-arrivedHour)*60 + examBeginMin-arrivedMin;
    }

    if(difference>=0 && difference<=30){
        console.log(`On time`);
        console.log(`${difference} minutes before the start`);
    }else if(difference>30){
        console.log(`Early`);
        if(difference>=60){
            console.log(`${difference/60}:${difference%60} hours before the start`);
        }else{
        console.log(`${difference} minutes before the start`);
        }
    }else{
        console.log(`Late`);
        if(difference>=60){
            console.log(`${difference/60}:${difference%60} hours after the start`);
        }else{
        console.log(`${difference} minutes after the start`);
        }
    }
}