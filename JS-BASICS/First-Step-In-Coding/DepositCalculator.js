function greetingByNmae(input){
    let depositSum = (Number)(input[0]);
    let period = (Number)(input[1]);
    let  interest = (Number)(input[2])/100;
    let finalSum = depositSum+period*((depositSum*interest)/12);

    console.log(finalSum);
}
