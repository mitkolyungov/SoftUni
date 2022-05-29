function isExcelent(input){
    let budget = Number(input[0]);
    let videoCards = Number(input[1]);
    let processors = Number(input[2]);
    let ram = Number(input[3]);
    
    let videoCardsPrice = videoCards*250;
    let processorsPrice = videoCardsPrice*0.35*processors;
    let ramPrice = videoCardsPrice*0.1*ram;
    
    let totalSum = videoCardsPrice+processorsPrice+ramPrice;
    
    if(videoCards>processors){
        totalSum*=0.85;
    }
    
    if(totalSum>budget){
        console.log(`Not enough money! You need ${(totalSum-budget).toFixed(2)} leva more!`)
    }else{
        console.log(`You have ${(budget-totalSum).toFixed(2)} leva left!`)
    }
    }