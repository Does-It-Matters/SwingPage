package org.example.core.page.presentation

import org.example.utils.Mode
import org.example.utils.ModeManager
import java.awt.BorderLayout
import java.awt.Color
import java.awt.FlowLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.util.*
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel

class NavigationFrame(title: String?) : JFrame(title) {
    private val historyStack: Deque<AbstractIPage> = ArrayDeque<AbstractIPage>()
    private val forwardStack: Deque<AbstractIPage> = ArrayDeque<AbstractIPage>()
    private val contents = JPanel()

    private val prevBtn = JButton("<")
    private val nextBtn = JButton(">")

    private val navPanel = JPanel(FlowLayout(FlowLayout.LEFT, 10, 10))
    private val modeManager: ModeManager = ModeManager()

    init {
        setSize(500, 400)
        setDefaultCloseOperation(EXIT_ON_CLOSE)
        setLayout(BorderLayout())
        setLocationRelativeTo(null) // 화면 중앙 배치

        // 1. 상단 네비게이션 패널
        navPanel.setBackground(Color(245, 245, 245))

        // 버튼에 클릭 이벤트 연결
        prevBtn.addActionListener(ActionListener { e: ActionEvent? -> previous() })
        nextBtn.addActionListener(ActionListener { e: ActionEvent? -> next() })

        navPanel.add(prevBtn)
        navPanel.add(nextBtn)

        // 2. 메인 프레임에 배치
        add(navPanel, BorderLayout.NORTH)

        contents.setLayout(BorderLayout())
        add(contents, BorderLayout.CENTER)

        // 3. 다크 모드 추가
        val themeBtn = this.button
        addMenu(themeBtn)

        modeManager.applyTheme()
        setVisible(true)
    }

    fun injectContents(page: AbstractIPage) {
        if (!historyStack.isEmpty() && historyStack.peek() === page) {
            return
        }

        forwardStack.clear()
        historyStack.push(page)

        setContents(page)
    }

    fun addMenu(menu: JButton?) {
        navPanel.add(menu)
    }

    private fun next() {
        if (!forwardStack.isEmpty()) {
            val next: AbstractIPage = forwardStack.pop()
            historyStack.push(next)
            setContents(next)
        }
    }

    private fun previous() {
        if (historyStack.size > 1) {
            val current: AbstractIPage? = historyStack.pop()
            forwardStack.push(current)

            val previous: AbstractIPage = historyStack.peek()
            setContents(previous)
        }
    }

    private fun setContents(page: AbstractIPage) {
        val center: JPanel? = page.panel
        setTitle(page.title)
        contents.removeAll() // 중앙 내용 삭제
        contents.add(center, BorderLayout.CENTER) // 중앙 내용 추가
        renderPage()
    }

    private fun renderPage() {
        prevBtn.setEnabled(historyStack.size > 1)
        nextBtn.setEnabled(!forwardStack.isEmpty())
        contents.revalidate()
        contents.repaint()
    }

    private val button: JButton
        get() {
            val themeBtn = JButton("모드")
            themeBtn.addActionListener(
                ActionListener { e: ActionEvent? ->
                    modeManager.toggle()
                    val text = if (modeManager.state == Mode.DARK) "라이트 모드" else "다크 모드"
                    themeBtn.setText(text)
                }
            )
            return themeBtn
        }
}