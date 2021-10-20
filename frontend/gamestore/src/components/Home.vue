<template>
    <div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#/">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#/game">Lista de Games</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#/sobre">Sobre nós</a>
      </li>
    </ul>
  </div>
</nav>
<b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      background="#ababab"
      img-width="1024"
      img-height="480"
      style="text-shadow: 1px 1px 2px #333"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >

      <b-carousel-slide
        caption="NBA 2K21"
        text="“NBA 2K21 é o título mais recente da série NBA 2K, mundialmente famosa e mais vendida, proporcionando uma experiência de videogame de esportes líder do setor."
        img-src="https://store.nintendo.com.br/media/catalog/product/cache/1aff59ff6f21b2058ac5563c018426d7/2/k/2ksmkt_nba2k21_std_nintendoeshop_banner_1920x1080.jpg"
      >
       
      </b-carousel-slide>

      <b-carousel-slide
        caption="GTA V"
        text="Grand Theft Auto V é um jogo eletrônico de ação-aventura desenvolvido pela Rockstar North e publicado pela Rockstar Games. É o sétimo título principal da série Grand Theft Auto."
        img-src="https://i.pinimg.com/originals/9f/3c/9e/9f3c9e90afbe301f43cb3a1d90751642.jpg"
      >
      </b-carousel-slide>

      <b-carousel-slide
      
        text="Watch Dogs Legion é o terceiro game da série Watch Dogs, da Ubisoft, e traz uma proposta ambiciosa: permitir que você recrute quase qualquer pessoa para fazer parte da resistência. Sem um protagonista definido, o game te dá a liberdade de explorar diferentes tipos de gameplay."
        img-src="https://programadoresbrasil.com.br/wp-content/uploads/2020/10/watchdogs-banner.jpg"
      ></b-carousel-slide>
    </b-carousel>
    </div>
</template>
<script>

</script>

<style lang="stylus">
</style>