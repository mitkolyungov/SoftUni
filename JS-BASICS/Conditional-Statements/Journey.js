function calculatePrice(input){
    let budget = Number(input[0]);
    let season = input[1];
    let holidayPlace;
    let accommodationPlace;

    let expenditures = 0;

    if(budget<=100){
        if(season=="summer"){
            expenditures = budget*0.3;
            accommodationPlace = "Camp";
        }else if(season=="winter"){
            accommodationPlace="Hotel";
            expenditures = budget*0.7;
        }
        holidayPlace="Bulgaria";
    }else if(budget<=1000){
        if(season=="summer"){
            expenditures = budget*0.4;
            accommodationPlace = "Camp";

        }else if(season=="winter"){
            expenditures = budget*0.8;
            accommodationPlace="Hotel";

        }
        holidayPlace="Balkans";
    }else if(budget>1000){
        expenditures = budget*0.9;
        holidayPlace="Europe";
        accommodationPlace="Hotel";
    }

    console.log(`Somewhere in ${holidayPlace}`);
    console.log(`${accommodationPlace} - ${expenditures.toFixed(2)}`);

}