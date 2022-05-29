function isExcelent(input){
    let movieName = input[0];
    let movieDuration = Number(input[1]);
    let breakDuration = Number(input[2]);
    
    let lunch = breakDuration/8;
    let relax = breakDuration/4;
    
    breakDuration = breakDuration-lunch-relax;
    
    if(breakDuration>=movieDuration){
        console.log(`You have enough time to watch ${movieName} and left with ${Math.ceil(breakDuration-movieDuration)} minutes free time.`)
    }else{
        console.log(`You don't have enough time to watch ${movieName}, you need ${Math.ceil(movieDuration-breakDuration)} more minutes.`)
    }
    }