function exam(input){
    let computersCount = Number(input.shift());

    let totalSales = 0;
    let totalRating = 0;


    for (let index = 0; index < computersCount; index++) {
        let number = input.shift();

        let sales = Math.floor(Number(number) / 10);
        let rating = Number(number) % 10;

        totalRating+=rating;

        let tempSales = 0;

        if(rating==2){
            tempSales = sales*0;
        }else if(rating==3){
            tempSales = sales*0.5;
        }else if(rating==4){
            tempSales = sales*0.7;
        }else if(rating==5){
            tempSales = sales*0.85;
        }else if(rating==6){
            tempSales = sales;
        }

        totalSales += tempSales;
    }


    console.log(totalSales.toFixed(2));
    console.log((totalRating/computersCount).toFixed(2));

}