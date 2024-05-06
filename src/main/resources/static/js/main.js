async function logProducts() {
  const response = await fetch("/api/products");
  const products = await response.json();
  console.log(products);
}

const hello = () => alert("It works");
hello();

getProducts = () => {
    return fetch("/api/products").then(response => response.json());
}

getCurrentOffer = () => {
    return fetch("/api/current-offer").then(response => response.json());
}