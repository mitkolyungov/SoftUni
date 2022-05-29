function calculatePrice(input){
    let budget = Number(input[0]);
    let season = input[1];
    let fishersCount = Number(input[2]);

    let expenditures = 0;

    if(season=="Spring"){
        expenditures = 3000;
    }else if(season == "Summer" || season=="Autumn"){
        expenditures = 4200;
    }else if(season=="Winter"){
        expenditures = 2600;
    }

    if(fishersCount > 0 && fishersCount<=6){
        expenditures*=0.9;
    }else if(fishersCount>=7 && fishersCount<=11){
        expenditures*=0.85;
    }else if(fishersCount>=12){
        expenditures*=0.75;
    }

    if(fishersCount%2==0 && season!="Autumn"){
        expenditures*=0.95;
    }

    if(budget>=expenditures){
        console.log(`Yes! You have ${(budget-expenditures).toFixed(2)} leva left.`);
    }else{
        console.log(`Not enough money! You need ${(expenditures-budget).toFixed(2)} leva.`);
    }
}