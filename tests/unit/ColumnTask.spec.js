import ColumnTask from "../../src/components/ColumnTask";
import { mount, createLocalVue } from "@vue/test-utils";
import VueRouter from "vue-router";
import mockRouter from "../mockRouter";
import initBoard from "../../src/init-board";
import flushPromises from "flush-promises";

const localVue = createLocalVue();
localVue.use(VueRouter);
const router = mockRouter.mock();

let defaultBoard = "";
beforeEach(() => {
  defaultBoard = JSON.parse(JSON.stringify(initBoard));
});

describe("ColumnTask", () => {
  it("should open modal", async () => {
    //given
    const wrapper = mount(ColumnTask, {
      localVue,
      router,
      propsData: {
        column: defaultBoard.columns[0],
        columnIndex: 0,
        board: defaultBoard,
        task: defaultBoard.columns[0].tasks[0],
        taskIndex: 0
      }
    });
    //when
    wrapper.find(".task").trigger("click");
    await flushPromises();
    //then
    expect(wrapper.vm.$route.name).toEqual("task");
  });
});
