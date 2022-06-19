function exam(input){
    let dressCount = Number(input[0])*5.8;
    let rollsCount = Number(input[1])*7.2;
    let glueQuantity = Number(input[2])*1.2;
    let discount = Number(input[3]);


    let total = Number((dressCount+rollsCount+glueQuantity)*(1-discount/100));

    console.log(total.toFixed(3));
}