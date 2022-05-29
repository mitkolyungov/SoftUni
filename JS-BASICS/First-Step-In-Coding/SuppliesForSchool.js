function greetingByNmae(input){
    let pens = (Number)(input[0]);
    let markers = (Number)(input[1]);
    let  cleaningDetergent = (Number)(input[2]);
    let discount = (Number)(input[3]);

    let priceOfPens = pens*5.80;
    let priceOfMarkers = markers*7.2;
    let priceOfDetergent = cleaningDetergent*1.2;

    console.log((priceOfDetergent+priceOfMarkers+priceOfPens)*((100-discount)/100));
}
