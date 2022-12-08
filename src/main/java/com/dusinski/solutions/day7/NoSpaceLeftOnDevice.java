package com.dusinski.solutions.day7;

import com.dusinski.utils.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class NoSpaceLeftOnDevice {

    public static int getTotalSizeToRemovePart1(String inputName) {
        List<String> commandList = utils.loadStringList(inputName);
        Dir mainDir = getDirStructure(commandList);

        return getSumAtLeast100000(mainDir);
    }

    public static int getSmallestDirToBeDeletedPart2(String inputName) {
        List<String> commandList = utils.loadStringList(inputName);
        Dir mainDir = getDirStructure(commandList);

        int requiredSize = 30000000 - (70000000 - mainDir.getDirTotalSize());
        return getSmallestDirToDelete(mainDir, requiredSize);
    }


    private static Dir getDirStructure(List<String> commandList) {
        Dir startDir = new Dir(null, "/");
        Dir tempDir = startDir;
        ListIterator<String> commandIterator = commandList.listIterator();
        commandIterator.next();

        while (commandIterator.hasNext()) {
            String currentCommand = commandIterator.next();
            if (currentCommand.contains("$ cd")) {
                String dirName = currentCommand.split(" ")[2];
                if (dirName.equals("..")) {
                    tempDir = tempDir.upperDir;
                } else {
                    tempDir = tempDir.getSubDir(dirName);
                }

            } else if (currentCommand.contains("$ ls")) {
                while (commandIterator.hasNext()) {
                    currentCommand = commandIterator.next();
                    String cmd = currentCommand.split(" ")[0];
                    String param = currentCommand.split(" ")[1];
                    if (cmd.equals("dir")) {
                        tempDir.addSubDir(param);
                    } else if (Character.isDigit(cmd.charAt(0))) {
                        int fileSize = Integer.parseInt(cmd);
                        tempDir.addFile(param, fileSize);
                    } else if (cmd.equals("$")) {
                        currentCommand = commandIterator.previous();
                        break;
                    }
                }
            }
        }
        return startDir;
    }

    private static int getSumAtLeast100000(Dir inputDir) {
        int result = 0;
        for (Dir d : inputDir.subDirList) {
            result += getSumAtLeast100000(d);
            int currentSize = d.getDirTotalSize();
            if (currentSize <= 100000) {
                result += currentSize;
            }
        }
        return result;
    }

    private static int getSmallestDirToDelete(Dir inputDir, int requiredSpace) {
        int currentSize = inputDir.getDirTotalSize();
        if (currentSize <= requiredSpace) {
            currentSize = Integer.MAX_VALUE;
        }

        for (Dir d : inputDir.subDirList) {
            currentSize = Math.min(currentSize, getSmallestDirToDelete(d, requiredSpace));
        }
        return currentSize;
    }

    private static class Dir {
        private final Dir upperDir;
        private final String name;
        private final List<Dir> subDirList = new LinkedList<>();
        private final List<File> fileList = new LinkedList<>();

        public Dir(Dir upperDir, String name) {
            this.upperDir = upperDir;
            this.name = name;
        }

        private Dir getSubDir(String subDirNme) {
            for (Dir subDir : this.subDirList) {
                if (subDir.name.equals(subDirNme)) {
                    return subDir;
                }
            }
            return null;
        }

        private void addSubDir(String name) {
            this.subDirList.add(new Dir(this, name));
        }

        private void addFile(String fileName, int size) {
            this.fileList.add(new File(fileName, size));
        }

        private int getDirTotalSize() {
            int sizeSum = getFileTotalSize();
            for (Dir d : this.subDirList) {
                sizeSum += d.getDirTotalSize();
            }
            return sizeSum;
        }

        private int getFileTotalSize() {
            int sizeSum = 0;
            for (File f : this.fileList) {
                sizeSum += f.getSize();
            }
            return sizeSum;
        }

        private static class File {
            private final String name;
            private final int size;

            public File(String name, int size) {
                this.name = name;
                this.size = size;
            }

            public int getSize() {
                return size;
            }
        }
    }
}
