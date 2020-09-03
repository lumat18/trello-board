import BoardColumn from "../../src/components/BoardColumn";
import { mount, createLocalVue } from "@vue/test-utils";
import initBoard from "../../src/init-board";
import { uuid } from "../../src/utils";

import Vuex from "vuex";

const localVue = createLocalVue();
localVue.use(Vuex);

const store = new Vuex.Store({
  state: {
    board: initBoard
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
        column: initBoard.columns[0],
        board: initBoard
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
});
