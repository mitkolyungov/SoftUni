function greetingByNmae(input){
    let length = (Number)(input[0]);
    let width = (Number)(input[1]);
    let high = (Number)(input[2]);
    let percentage = (Number)(input[3]);


    console.log(length*width*high*((100-percentage)/100)/1000);
}
