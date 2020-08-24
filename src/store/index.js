import Vue from "vue";
import Vuex from "vuex";
import initBoard from "../init-board";

Vue.use(Vuex);

const board = JSON.parse(localStorage.getItem("board")) || initBoard;

export default new Vuex.Store({
  state: {
    board
  },
  mutations: {},
  actions: {},
  modules: {}
});
