function calculateAccommodation(input){
    let season = input[0];
    let nightsCount = Number(input[1]);

    let apartmentPrice = 0;
    let studioPrice = 0;

    if(season=="May" || season=="October"){
        if(nightsCount>14){
            apartmentPrice = nightsCount*65*0.9;
            studioPrice = nightsCount*50*0.7;
        }else if(nightsCount>7){
            studioPrice = nightsCount*50*0.95;
            apartmentPrice = nightsCount*65;
        }else if(nightsCount>=0){
            apartmentPrice = nightsCount*65;
            studioPrice = nightsCount*50;
        }
    }else if(season=="June" || season=="September"){
        if(nightsCount>14){
            apartmentPrice = nightsCount*68.7*0.9;
            studioPrice = nightsCount*75.2*0.8;
        }else if(nightsCount>=0) {
            apartmentPrice = nightsCount*68.7;
            studioPrice = nightsCount*75.2;
        }
    }else if(season=="July" || season=="August"){
        if(nightsCount>14){
            apartmentPrice = nightsCount*77*0.9;
            studioPrice = nightsCount*76;
        }else if(nightsCount>=0){
        apartmentPrice = nightsCount*77;
        studioPrice = nightsCount*76;
        }
    }

    console.log(`Apartment: ${apartmentPrice.toFixed(2)} lv.`);
    console.log(`Studio: ${studioPrice.toFixed(2)} lv.`)
}