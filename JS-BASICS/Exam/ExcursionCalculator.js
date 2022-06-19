function exam(input){
    let peopleCount = Number(input.shift());
    let season = (input.shift());

    let totalPrice = 0;

    if(season=="spring"){
        if(peopleCount<=5){
            totalPrice = 50*peopleCount;
        }else{
            totalPrice = 48*peopleCount;
        }
    }else if(season=="summer"){
        if(peopleCount<=5){
            totalPrice = 48.5*peopleCount;
        }else{
            totalPrice = 45*peopleCount;
        }

        totalPrice*=0.85;

    }else if(season=="autumn"){
        if(peopleCount<=5){
            totalPrice = 60*peopleCount;
        }else{
            totalPrice = 49.5*peopleCount;
        }
    }else if(season=="winter"){
        if(peopleCount<=5){
            totalPrice = 86*peopleCount;
        }else{
            totalPrice = 85*peopleCount;
        }

        totalPrice*=1.08;
    }

    console.log(`${totalPrice.toFixed(2)} leva.`)

}