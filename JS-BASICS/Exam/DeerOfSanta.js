function exam(input){
    let daysCount = Number(input.shift());
    let foodKg = Number(input.shift());
    let foodPerDayFirstDeer = Number(input.shift());
    let foodPerDaySecondDeer = Number(input.shift());
    let foodPerDayThirdDeer = Number(input.shift());

    let totalKgNeeded = Number(foodPerDayFirstDeer*daysCount
        + foodPerDaySecondDeer*daysCount
        +foodPerDayThirdDeer*daysCount);

    
    if (foodKg>=totalKgNeeded) {
        console.log(`${Math.floor(foodKg-totalKgNeeded)} kilos of food left.`)
    }else{
        console.log(`${Math.ceil(totalKgNeeded-foodKg)} more kilos of food are needed.`)

    }


}