function greetingByNmae(input){
    let nylon = (Number)(input[0])+2;
    let paint = (Number)(input[1])*1.1;
    let paintThinner = (Number)(input[2]);
    let hoursNeeded = (Number)(input[3]);
    let bags = (Number)(0.40);

    let nylonPrice = nylon*1.50;
    let paintPrice = paint*14.50;
    let paintThinnerPrice = paintThinner*5;

    let totalExpenditures = nylonPrice+paintPrice+paintThinnerPrice+0.4;

    let workersSalary = totalExpenditures*0.3*hoursNeeded;

    console.log(totalExpenditures+workersSalary);
}
