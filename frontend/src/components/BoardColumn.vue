<template>
  <AppDrop @drop="moveTaskOrColumn">
    <AppDrag
      class="column"
      :transfer-data="{
        type: 'column',
        fromColumnIndex: columnIndex
      }"
    >
      <div class="column-name">{{ column.name }}</div>
      <ColumnTask
        v-for="(task, $taskIndex) in column.tasks"
        :key="$taskIndex"
        :task="task"
        :taskIndex="$taskIndex"
        :column="column"
        :columnIndex="columnIndex"
        :board="board"
      />
      <input
        :class="'task-input' + columnIndex"
        type="text"
        placeholder="+ Add task"
        @keyup.enter="createTask($event, column.tasks)"
      />
    </AppDrag>
  </AppDrop>
</template>

<script>
import ColumnTask from "./ColumnTask";
import MovingTasksAndColumnsMixin from "../mixins/MovingTasksAndColumnsMixin";
import AppDrag from "./AppDrag";
import AppDrop from "./AppDrop";

export default {
  name: "BoardColumn",
  mixins: [MovingTasksAndColumnsMixin],
  components: {
    ColumnTask,
    AppDrag,
    AppDrop
  },
  methods: {
    createTask(event, tasks) {
      this.$store.commit("CREATE_TASK", {
        tasks,
        name: event.target.value,
        columnId: this.columnIndex
      });
      event.target.value = "";
    }
  }
};
</script>

<style scoped>
.column {
  border: 1px solid black;
  margin: 8px;
  padding: 4px;
  border-radius: 8px;
  width: 250px;
}
.column-name {
  font-weight: bolder;
}
</style>
