function vocation(input) {
    let neededMoney = Number(input[0]);
    let availableMoney = Number(input[1]);

    let daysCounter = 0;
    let spendingDays = 0;
    let index = 2;

    while (availableMoney < neededMoney) {
        let action = input[index++];
        let money = Number(input[index++]);
        daysCounter++;

        if(action == "spend"){
            spendingDays++;
            
            if(spendingDays==5){
                console.log(`You can't save the money.`);
                console.log(daysCounter);
                return;
            }
            availableMoney-=money;

            if(availableMoney<0){
                availableMoney=0;
            }

        }else if (action == "save") {
            spendingDays = 0;
            availableMoney+=money;
        }
    }

    console.log(`You saved the money for ${daysCounter} days.`);
}