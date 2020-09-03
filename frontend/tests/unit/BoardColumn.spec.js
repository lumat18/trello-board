import BoardColumn from "../../src/components/BoardColumn";
import { mount, createLocalVue } from "@vue/test-utils";
import initBoard from "../../src/init-board";
import { uuid } from "../../src/utils";

import Vuex from "vuex";

const localVue = createLocalVue();
localVue.use(Vuex);

let defaultBoard = "";
let store = "";

function resetStore(store) {
  defaultBoard = JSON.parse(JSON.stringify(initBoard));
  store.state.board = defaultBoard;
}

beforeEach(() => {
  store = new Vuex.Store({
    state: {
      board: null
    },
    mutations: {
      CREATE_TASK(state, { tasks, name }) {
        tasks.push({
          name,
          id: uuid(),
          description: ""
        });
      }
    }
  });
  resetStore(store);
});

describe("BoardColumn", () => {
  it("should be true", () => {
    expect(true).toBe(true);
  });

  it("should create new task", () => {
    //given
    const wrapper = mount(BoardColumn, {
      store,
      localVue,
      propsData: {
        columnIndex: 0,
        column: defaultBoard.columns[0],
        board: defaultBoard
      }
    });
    const numberOfTasksBefore = store.state.board.columns[0].tasks.length;
    //when
    wrapper.find(".task-input0").setValue("foo");
    wrapper.find(".task-input0").trigger("keyup.enter");
    //then
    const numberOfTasksAfter = store.state.board.columns[0].tasks.length;
    expect(numberOfTasksAfter).toBeGreaterThan(numberOfTasksBefore);
  });

  it("should mount 3 tasks", () => {
    //given
    const wrapper = mount(BoardColumn, {
      store,
      localVue,
      propsData: {
        columnIndex: 0,
        column: defaultBoard.columns[0],
        board: defaultBoard
      }
    });
    //when then
    const numberOfTasksMounted = wrapper.findAll(".task").length;
    expect(numberOfTasksMounted).toBe(3);
  });
});
