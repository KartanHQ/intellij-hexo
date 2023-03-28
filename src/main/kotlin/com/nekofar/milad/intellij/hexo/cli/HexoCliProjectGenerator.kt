package com.nekofar.milad.intellij.hexo.cli

import com.intellij.execution.filters.Filter
import com.intellij.lang.javascript.boilerplate.NpmPackageProjectGenerator
import com.intellij.lang.javascript.boilerplate.NpxPackageDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.vfs.VirtualFile
import com.nekofar.milad.intellij.hexo.HexoBundle
import com.nekofar.milad.intellij.hexo.HexoIcons
import javax.swing.Icon

class HexoCliProjectGenerator : NpmPackageProjectGenerator() {
    private val packageName = "hexo"
    private val executable = "hexo"
    private val initCommand = "init"

    override fun getName(): String {
        return HexoBundle.message("hexo.project.generator.name")
    }

    override fun getDescription(): String {
        return HexoBundle.message("hexo.project.generator.description")
    }

    override fun filters(project: Project, baseDir: VirtualFile): Array<Filter> {
        return emptyArray()
    }

    override fun customizeModule(p0: VirtualFile, p1: ContentEntry?) {}

    override fun packageName(): String {
        return packageName
    }

    override fun presentablePackageName(): String {
        return HexoBundle.message("hexo.project.generator.presentable.package.name")
    }

    override fun getNpxCommands(): List<NpxPackageDescriptor.NpxCommand> {
        return listOf(NpxPackageDescriptor.NpxCommand(packageName, executable))
    }

    override fun generateInTemp(): Boolean {
        return true
    }

    override fun generatorArgs(project: Project?, dir: VirtualFile?, settings: Settings?): Array<String> {
        return arrayOf(initCommand, project?.name.toString())
    }

    override fun getIcon(): Icon {
        return HexoIcons.ProjectGenerator
    }
}
