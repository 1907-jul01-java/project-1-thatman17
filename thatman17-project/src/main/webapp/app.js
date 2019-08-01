let movies = [];
let moviesElement = document.querySelector('#movies');

function ListMovies(movies) {
    return `<table>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Year</th>
                </tr>
                ${movies.map(ListMovie).join('')}
            </table>`;
}

function ListMovie(transaction) {
    return `<tr>
                <td>${transaction.username}</td>
                <td>${transaction.cost}</td>
                <td>${transaction.picture}</td>
            </tr>`;
}

function updateMoviesElement() {
    moviesElement.innerHTML = ListMovies(movies);
}

function getMovies() {
    let xhr = new XMLHttpRequest();
    xhr.open('get', 'v1/movies/');
    xhr.onload = function() { 
        movies = JSON.parse(xhr.responseText); 
        updateMoviesElement();
    };
    xhr.send();
}
