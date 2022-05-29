function isExcelent(input){
    let tripPrice = Number(input[0]);
    let puzzles = Number(input[1]);
    let dolls = Number(input[2]);
    let tedyBears = Number(input[3]);
    let minions = Number(input[4]);
    let lorries = Number(input[5]);
 
    let puzzlesPrice = puzzles*2.6;
    let dollsPrize = dolls*3;
    let tedyBearsPrice = tedyBears*4.1;
    let minionsPrice = minions*8.2;
    let lorriesPrice = lorries*2;
 
    let totalSum = puzzlesPrice+dollsPrize+tedyBearsPrice
                     +minionsPrice+lorriesPrice;
 
     let numberOfToys = puzzles+dolls+tedyBears+minions+lorries;
 
     if(numberOfToys>=50){
         totalSum*=0.75;
     }
 
     let rent = 0.1;
     totalSum = totalSum*(1-rent);
 
     if(totalSum>=tripPrice){
         console.log(`Yes! ${(totalSum-tripPrice).toFixed(2)} lv left.`);
     }else{
         console.log(`Not enough money! ${(tripPrice-totalSum).toFixed(2)} lv needed.`); 
     }
 }
 