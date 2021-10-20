<template>
  <div id="games">
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
    <table class="table table-hover table">
      <tbody>
        <tr v-for="game in games" :key="game.id">
          <td>
           {{ game.titulo }}
          </td>
          <td >R${{ game.preco }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import gameService from "@/service/gameService.js";
export default {
  data() {
    return {
      games: [],
    };
  },
  created() {
    gameService.obterTodos()
      .then((response) => {
        this.games = response.data.dados;
      })
      .catch((error) => {
        console.log(error);
      });
  }
};
</script>
<style scoped>
h1 {
  background-color: black;
  color: white;
  font-family: Optima, sans-serif;
  text-align: center;
}
table {
  font-family: OCR A Std, monospace;
}
</style>