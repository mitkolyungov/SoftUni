function greetingByNmae(input){
    let numberOfPages = (Number)(input[0]);
    let numberOfPagesPerHour = (Number)(input[1]);
    let  numberOfDays = (Number)(input[2]);
    let hoursNeeded = numberOfPages/numberOfPagesPerHour/numberOfDays;

    console.log(hoursNeeded);
}
