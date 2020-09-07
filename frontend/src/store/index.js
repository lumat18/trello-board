import Vue from "vue";
import Vuex from "vuex";
import initBoard from "../init-board";
import { saveStatePlugin } from "../utils";
import axios from "axios";

Vue.use(Vuex);

const board = JSON.parse(localStorage.getItem("board")) || initBoard;

export default new Vuex.Store({
  plugins: [saveStatePlugin],
  state: {
    board
  },
  getters: {
    getTask(state) {
      return id => {
        for (const column of state.board.columns) {
          for (const task of column.tasks) {
            if (task.id == id) {
              return task;
            }
          }
        }
      };
    }
  },
  mutations: {
    CREATE_TASK(state, { tasks, name, columnId }) {
      const api = "http://localhost:8082/task/create";
      axios
        .post(api, {
          name: name,
          description: "",
          userAssigned: "",
          boardColumnId: columnId + 1
        })
        .then(response => response.data)
        .then(data => {
          console.log("response.data: ", data);
          tasks.push(data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    CREATE_COLUMN(state, { name }) {
      state.board.columns.push({
        name,
        tasks: []
      });
    },
    UPDATE_TASK(state, { task, key, value }) {
      Vue.set(task, key, value);
    },
    MOVE_TASK(
      state,
      { fromColumnTasks, toColumnTasks, taskIndex, toTaskIndex }
    ) {
      const taskToMove = fromColumnTasks.splice(taskIndex, 1)[0];
      toColumnTasks.splice(toTaskIndex, 0, taskToMove);
    },
    MOVE_COLUMN(state, { fromColumnIndex, toColumnIndex }) {
      const columnList = state.board.columns;
      const columnToMove = columnList.splice(fromColumnIndex, 1)[0];
      columnList.splice(toColumnIndex, 0, columnToMove);
    }
  },
  actions: {},
  modules: {}
});
