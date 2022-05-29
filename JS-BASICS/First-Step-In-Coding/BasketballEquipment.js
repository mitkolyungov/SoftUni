function greetingByNmae(input){
    let annualFee = (Number)(input[0]);

    let shoesPrice = annualFee*0.6;
    let clothesPrice = shoesPrice*0.8;
    let ballPrice = clothesPrice*0.25;
    let accPrice = ballPrice*0.2;

    console.log(annualFee+shoesPrice+clothesPrice+ballPrice+accPrice);
}
