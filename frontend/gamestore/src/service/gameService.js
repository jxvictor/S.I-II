import apiClient from '../service/configService.js'

export default{
    obterTodos(){
        return apiClient.get('/game')
    },
    obterPorId(id)
    {
        return apiClient.get('/game/'+id)
    },
    selecionarGame(id)
    {
        this.gameSelecionado = id;
    },
    getGameSelecionado(){
        return this.gameSelecionado
    }
}