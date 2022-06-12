function findFavouriteBook(input) {
    let favouriteBokok = input[0];

    let index = 1;
    let isFound = false;

    let nextBook = input[index];

    while (nextBook!=="No More Books") {
        if(nextBook==favouriteBokok){
            isFound = true;
            break;
        }
        7
        index++;
        nextBook = input[index];
    }


    if (isFound) {
        console.log(`You checked ${index - 1} books and found it.`)
    }else{
        console.log(`The book you search is not here!`)
        console.log(`You checked ${index - 1} books.`)
    }
}