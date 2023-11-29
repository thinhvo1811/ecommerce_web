const productImgItem = document.querySelectorAll('.product-detail__img-list--item')
const productImgMain = document.querySelector('.product-detail__img-main')

const handleClickImg = (e) => {
    for(var i = 0; i < productImgItem.length; i++){
        productImgItem[i].onclick = (e) => {
            productImgMain.style.backgroundImage = e.target.style.backgroundImage;
        }
    }
}

const start = () => {
    handleClickImg();
}

start();