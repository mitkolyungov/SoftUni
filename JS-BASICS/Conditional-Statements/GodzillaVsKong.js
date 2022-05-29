function isExcelent(input){
    let budget = Number(input[0]);
    let staffNumber = Number(input[1]);
    let clothesPrice = Number(input[2]);
 
    let decoration = budget*0.1;
 
    if(staffNumber>150){
        clothesPrice*=0.9;
    }
 
    let totalExpenditures = decoration
                             +staffNumber*clothesPrice;
 
     
    if(totalExpenditures>budget){
        console.log(`Not enough money!\nWingard needs ${(totalExpenditures-budget).toFixed(2)} leva more.`);
     }else{
         console.log(`Action!\nWingard starts filming with ${(budget-totalExpenditures).toFixed(2)} leva left.`);
     }
 
 }
 